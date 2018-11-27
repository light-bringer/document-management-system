/**
 * ezDMS, Open Document Management System (http://www.ezdms.com)
 * Copyright (c) 2006-2017  Paco Avila & Josep Llort
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.ezdms.servlet.frontend;

import com.ezdms.api.OKMUserConfig;
import com.ezdms.bean.Repository;
import com.ezdms.core.DatabaseException;
import com.ezdms.core.RepositoryException;
import com.ezdms.dao.bean.UserConfig;
import com.ezdms.frontend.client.OKMException;
import com.ezdms.frontend.client.bean.GWTUserConfig;
import com.ezdms.frontend.client.constants.service.ErrorCode;
import com.ezdms.frontend.client.service.OKMUserConfigService;
import com.ezdms.util.GWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Class
 */
public class UserConfigServlet extends OKMRemoteServiceServlet implements OKMUserConfigService {
	private static Logger log = LoggerFactory.getLogger(UserConfigServlet.class);
	private static final long serialVersionUID = 1L;

	@Override
	public void setUserHome(String path) throws OKMException {
		log.debug("setUserHome({})", path);
		updateSessionManager();

		try {
			OKMUserConfig.getInstance().setHome(null, path);
		} catch (RepositoryException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMUserCopyService, ErrorCode.CAUSE_Repository), e.getMessage());
		} catch (DatabaseException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMUserCopyService, ErrorCode.CAUSE_Database), e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMUserCopyService, ErrorCode.CAUSE_General), e.getMessage());
		}

		log.debug("setUserHome: void");
	}

	@Override
	public GWTUserConfig getUserHome() throws OKMException {
		log.debug("getUserHome()");
		updateSessionManager();

		try {
			UserConfig config = OKMUserConfig.getInstance().getConfig(null);
			// Any home that will not have okm:root parent needs reseting ( normally because node is deleted to /okm:trash )
			if (!config.getHomePath().startsWith("/" + Repository.ROOT)) {
				config = OKMUserConfig.getInstance().getConfig(null);
			}
			return GWTUtil.copy(config);
		} catch (RepositoryException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMUserCopyService, ErrorCode.CAUSE_Repository), e.getMessage());
		} catch (DatabaseException e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMUserCopyService, ErrorCode.CAUSE_Database), e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new OKMException(ErrorCode.get(ErrorCode.ORIGIN_OKMUserCopyService, ErrorCode.CAUSE_General), e.getMessage());
		}
	}
}
