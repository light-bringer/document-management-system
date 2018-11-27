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

package com.ezdms.extension.servlet;

import com.ezdms.api.OKMDocument;
import com.ezdms.api.OKMFolder;
import com.ezdms.api.OKMMail;
import com.ezdms.api.OKMRepository;
import com.ezdms.bean.Document;
import com.ezdms.bean.Folder;
import com.ezdms.bean.Mail;
import com.ezdms.core.AccessDeniedException;
import com.ezdms.core.DatabaseException;
import com.ezdms.core.PathNotFoundException;
import com.ezdms.core.RepositoryException;
import com.ezdms.dao.DatabaseMetadataDAO;
import com.ezdms.dao.bean.DatabaseMetadataValue;
import com.ezdms.extension.frontend.client.bean.GWTExtendedSecurity;
import com.ezdms.extension.frontend.client.service.OKMCustomerService;
import com.ezdms.frontend.client.OKMException;
import com.ezdms.frontend.client.constants.service.ErrorCode;
import com.ezdms.servlet.frontend.OKMRemoteServiceServlet;
import com.ezdms.util.DatabaseMetadataUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * CustomerExtensionServlet
 *
 * @author jllort
 *
 */
public class CustomerExtensionServlet extends OKMRemoteServiceServlet implements OKMCustomerService {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(CustomerExtensionServlet.class);

	@Override
	public Double addExtendedSecurity(GWTExtendedSecurity security, boolean recursive) throws OKMException {
		log.debug("addExtendedSecurity({},{})", security, recursive);
		updateSessionManager();

		try {
			DatabaseMetadataValue dmv = DatabaseMetadataUtils.getDatabaseMetadataValueByMap(security.restoreToMap());
			Double id = (double) DatabaseMetadataDAO.createValue(dmv);

			if (recursive) {
				String path;
				path = OKMRepository.getInstance().getNodePath(null, security.getUuid());
				List<String> folders = new ArrayList<String>();
				folders.add(path);

				while (folders.size() > 0) {
					path = folders.remove(0);

					for (Folder folder : OKMFolder.getInstance().getChildren(null, path)) {
						folders.add(folder.getPath());
						security.setUuid(folder.getUuid());
						String filter = "$" + GWTExtendedSecurity.MV_COLUMN_NAME_UUID + "='" + folder.getUuid()
								+ "' and " + "$" + GWTExtendedSecurity.MV_COLUMN_NAME_TYPE + "='" + security.getType()
								+ "' and " + "$" + GWTExtendedSecurity.MV_COLUMN_NAME_NAME + "='" + security.getName()
								+ "'";
						String query = DatabaseMetadataUtils.buildQuery(GWTExtendedSecurity.MV_TABLE_NAME, filter, "");

						try {
							if (DatabaseMetadataDAO.executeValueQuery(query).isEmpty()) {
								DatabaseMetadataDAO.createValue(DatabaseMetadataUtils
										.getDatabaseMetadataValueByMap(security.restoreToMap()));
							}
						} catch (Exception e) {
							// Case value yet exists
						}
					}

					for (Document document : OKMDocument.getInstance().getChildren(null, path)) {
						security.setUuid(document.getUuid());
						String filter = "$" + GWTExtendedSecurity.MV_COLUMN_NAME_UUID + "='" + document.getUuid()
								+ "' and " + "$" + GWTExtendedSecurity.MV_COLUMN_NAME_TYPE + "='" + security.getType()
								+ "' and " + "$" + GWTExtendedSecurity.MV_COLUMN_NAME_NAME + "='" + security.getName()
								+ "'";
						String query = DatabaseMetadataUtils.buildQuery(GWTExtendedSecurity.MV_TABLE_NAME, filter, "");

						try {
							if (DatabaseMetadataDAO.executeValueQuery(query).isEmpty()) {
								DatabaseMetadataDAO.createValue(DatabaseMetadataUtils
										.getDatabaseMetadataValueByMap(security.restoreToMap()));
							}
						} catch (Exception e) {
							// Case value yet exists
						}
					}

					for (Mail mail : OKMMail.getInstance().getChildren(null, path)) {
						security.setUuid(mail.getUuid());
						String filter = "$" + GWTExtendedSecurity.MV_COLUMN_NAME_UUID + "='" + mail.getUuid()
								+ "' and " + "$" + GWTExtendedSecurity.MV_COLUMN_NAME_TYPE + "='" + security.getType()
								+ "' and " + "$" + GWTExtendedSecurity.MV_COLUMN_NAME_NAME + "='" + security.getName()
								+ "'";
						String query = DatabaseMetadataUtils.buildQuery(GWTExtendedSecurity.MV_TABLE_NAME, filter, "");

						try {
							if (DatabaseMetadataDAO.executeValueQuery(query).isEmpty()) {
								DatabaseMetadataDAO.createValue(DatabaseMetadataUtils
										.getDatabaseMetadataValueByMap(security.restoreToMap()));
							}
						} catch (Exception e) {
							// Case value yet exists
						}
					}
				}
			}

			return id;
		} catch (AccessDeniedException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMCustomerService, ErrorCode.CAUSE_AccessDenied), e.getMessage());
		} catch (PathNotFoundException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMCustomerService, ErrorCode.CAUSE_PathNotFound), e.getMessage());
		} catch (RepositoryException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMCustomerService, ErrorCode.CAUSE_Repository), e.getMessage());
		} catch (DatabaseException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMCustomerService, ErrorCode.CAUSE_Database), e.getMessage());
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMCustomerService, ErrorCode.CAUSE_IllegalAccess), e.getMessage());
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMCustomerService, ErrorCode.CAUSE_InvocationTarget), e.getMessage());
		}
	}

	@Override
	public void removeExtendedSecurity(GWTExtendedSecurity security, boolean recursive) throws OKMException {
		log.debug("removeExtendedSecurity({},{})", security, recursive);
		updateSessionManager();

		try {
			DatabaseMetadataValue dmv = DatabaseMetadataUtils.getDatabaseMetadataValueByMap(security.restoreToMap());
			DatabaseMetadataDAO.deleteValue(dmv.getId());

			if (recursive) {
				String path = OKMRepository.getInstance().getNodePath(null, security.getUuid());
				List<String> folders = new ArrayList<String>();
				folders.add(path);

				while (folders.size() > 0) {
					path = folders.remove(0);

					for (Folder folder : OKMFolder.getInstance().getChildren(null, path)) {
						folders.add(folder.getPath());
						String filter = "$" + GWTExtendedSecurity.MV_COLUMN_NAME_UUID + "='" + folder.getUuid()
								+ "' and " + "$" + GWTExtendedSecurity.MV_COLUMN_NAME_TYPE + "='" + security.getType()
								+ "' and " + "$" + GWTExtendedSecurity.MV_COLUMN_NAME_NAME + "='" + security.getName()
								+ "'";
						String query = DatabaseMetadataUtils.buildQuery(GWTExtendedSecurity.MV_TABLE_NAME, filter, "");
						for (DatabaseMetadataValue dmv2 : DatabaseMetadataDAO.executeValueQuery(query)) {
							DatabaseMetadataDAO.deleteValue(dmv2.getId());
						}
					}

					for (Document document : OKMDocument.getInstance().getChildren(null, path)) {
						String filter = "$" + GWTExtendedSecurity.MV_COLUMN_NAME_UUID + "='" + document.getUuid()
								+ "' and " + "$" + GWTExtendedSecurity.MV_COLUMN_NAME_TYPE + "='" + security.getType()
								+ "' and " + "$" + GWTExtendedSecurity.MV_COLUMN_NAME_NAME + "='" + security.getName()
								+ "'";
						String query = DatabaseMetadataUtils.buildQuery(GWTExtendedSecurity.MV_TABLE_NAME, filter, "");
						for (DatabaseMetadataValue dmv2 : DatabaseMetadataDAO.executeValueQuery(query)) {
							DatabaseMetadataDAO.deleteValue(dmv2.getId());
						}
					}

					for (Mail mail : OKMMail.getInstance().getChildren(null, path)) {
						String filter = "$" + GWTExtendedSecurity.MV_COLUMN_NAME_UUID + "='" + mail.getUuid()
								+ "' and " + "$" + GWTExtendedSecurity.MV_COLUMN_NAME_TYPE + "='" + security.getType()
								+ "' and " + "$" + GWTExtendedSecurity.MV_COLUMN_NAME_NAME + "='" + security.getName()
								+ "'";
						String query = DatabaseMetadataUtils.buildQuery(GWTExtendedSecurity.MV_TABLE_NAME, filter, "");
						for (DatabaseMetadataValue dmv2 : DatabaseMetadataDAO.executeValueQuery(query)) {
							DatabaseMetadataDAO.deleteValue(dmv2.getId());
						}
					}
				}
			}
		} catch (AccessDeniedException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMCustomerService, ErrorCode.CAUSE_AccessDenied), e.getMessage());
		} catch (PathNotFoundException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMCustomerService, ErrorCode.CAUSE_PathNotFound), e.getMessage());
		} catch (RepositoryException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMCustomerService, ErrorCode.CAUSE_Repository), e.getMessage());
		} catch (DatabaseException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMCustomerService, ErrorCode.CAUSE_Database), e.getMessage());
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMCustomerService, ErrorCode.CAUSE_IllegalAccess), e.getMessage());
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMCustomerService, ErrorCode.CAUSE_InvocationTarget), e.getMessage());
		}
	}
}