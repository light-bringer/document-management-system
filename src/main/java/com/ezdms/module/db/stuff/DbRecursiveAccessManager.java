/**
 * ezDMS, Open Document Management System (http://www.ezdms.com)
 * Copyright (c) 2006-2017 Paco Avila & Josep Llort
 * <p>
 * No bytes were intentionally harmed during the development of this application.
 * <p>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.ezdms.module.db.stuff;

import com.ezdms.core.AccessDeniedException;
import com.ezdms.core.Config;
import com.ezdms.core.DatabaseException;
import com.ezdms.core.PathNotFoundException;
import com.ezdms.dao.HibernateUtil;
import com.ezdms.dao.NodeBaseDAO;
import com.ezdms.dao.bean.NodeBase;
import com.ezdms.module.common.CommonAuthModule;
import com.ezdms.principal.PrincipalAdapterException;
import com.ezdms.spring.PrincipalUtils;
import com.ezdms.util.StackTraceUtils;
import com.ezdms.util.SystemProfiling;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Check user permissions on documents and folders.
 *
 * @author pavila
 * @see com.ezdms.module.db.stuff.DbSimpleAccessManager
 */
public class DbRecursiveAccessManager implements DbAccessManager {
	private static Logger log = LoggerFactory.getLogger(DbRecursiveAccessManager.class);
	public static final String NAME = "recursive";

	/**
	 * Check for permissions.
	 */
	public void checkPermission(NodeBase node, int permissions) throws AccessDeniedException, PathNotFoundException, DatabaseException {
		if (!isGranted(node, permissions)) {
			String nodePath = NodeBaseDAO.getInstance().getPathFromUuid(node.getUuid());
			throw new AccessDeniedException(node.getUuid() + " : " + nodePath);
		}
	}

	/**
	 * Check for permissions.
	 */
	@Override
	public boolean isGranted(NodeBase node, int permissions) throws DatabaseException {
		return isGranted(node, PrincipalUtils.getUser(), PrincipalUtils.getRoles(), permissions);
	}

	/**
	 * Check for permissions.
	 */
	@Override
	public boolean isGranted(NodeBase node, String user, int permissions) throws PrincipalAdapterException, DatabaseException {
		List<String> roles = CommonAuthModule.getPrincipalAdapter().getRolesByUser(user);
		return isGranted(node, user, new HashSet<String>(roles), permissions);
	}

	/**
	 * Check for permissions.
	 */
	private boolean isGranted(NodeBase node, String user, Set<String> roles, int permissions) throws DatabaseException {
		log.debug("isGranted({}, {})", node.getUuid(), permissions);
		long begin = System.currentTimeMillis();
		boolean access = false;

		if (user != null) {
			if (Config.SYSTEM_USER.equals(user) || Config.ADMIN_USER.equals(user)) {
				// An okmAdmin user has total access
				access = true;
			} else {
				if (roles.contains(Config.DEFAULT_ADMIN_ROLE)) {
					// An user with AdminRole has total access
					access = true;
				} else {
					Session session = null;

					try {
						session = HibernateUtil.getSessionFactory().openSession();
						access = recursiveIsGranted(session, node, user, roles, permissions);
					} finally {
						HibernateUtil.close(session);
					}
				}
			}
		} else {
			// access = true;

			log.info("***************************");
			log.info("***************************");
			StackTraceUtils.logTrace(log);
			log.info("***************************");
			log.info("***************************");
		}

		SystemProfiling.log(String.valueOf(node), System.currentTimeMillis() - begin);
		log.trace("isGranted.Node: {}, Time: {}", node.getUuid(), System.currentTimeMillis() - begin);
		log.debug("isGranted: {}", access);
		return access;
	}

	private boolean recursiveIsGranted(Session session, NodeBase node, String user, Set<String> roles, int perms) throws DatabaseException {
		if (log.isDebugEnabled()) {
			log.debug("recursiveIsGranted({}, {}, {}, {})", new Object[]{NodeBaseDAO.getInstance().getParentUuid(node.getUuid()), user,
					roles, perms});
		}

		boolean access = checkProperties(node.getUserPermissions(), node.getRolePermissions(), user, roles, perms);

		if (!Config.ROOT_NODE_UUID.equals(node.getParent())) {
			NodeBase parent = NodeBaseDAO.getInstance().getParentNodePermissions(session, node.getUuid());

			while (parent != null) {
				access &= recursiveIsGranted(session, parent, user, roles, perms);
				parent = NodeBaseDAO.getInstance().getParentNodePermissions(session, parent.getUuid());
			}
		}

		log.debug("recursiveIsGranted: {}", access);
		return access;
	}

	/**
	 * Check access properties
	 */
	private boolean checkProperties(Map<String, Integer> usersPerms, Map<String, Integer> rolesPerms, String user, Set<String> roles,
	                                int perms) {
		log.debug("checkProperties({}, {}, {}, {})", new Object[]{usersPerms, rolesPerms, roles, perms});
		boolean access = false;

		// Fist try with user permissions
		Integer userPerms = usersPerms.get(user);

		if (userPerms != null && (perms & userPerms) != 0) {
			log.debug("checkProperties: {}", true);
			return true;
		}

		// If there is no user specific access, try with roles permissions
		for (String role : roles) {
			Integer rolePerms = rolesPerms.get(role);

			if (rolePerms != null && (perms & rolePerms) != 0) {
				log.debug("checkProperties: {}", true);
				return true;
			}
		}

		log.debug("checkProperties: {}", access);
		return access;
	}
}
