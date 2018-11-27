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

package com.ezdms.api;

import com.ezdms.core.AccessDeniedException;
import com.ezdms.core.DatabaseException;
import com.ezdms.core.RepositoryException;
import com.ezdms.dao.bean.UserConfig;
import com.ezdms.module.ModuleManager;
import com.ezdms.module.UserConfigModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author pavila
 *
 */
public class OKMUserConfig implements UserConfigModule {
	private static Logger log = LoggerFactory.getLogger(OKMUserConfig.class);
	private static OKMUserConfig instance = new OKMUserConfig();

	private OKMUserConfig() {
	}

	public static OKMUserConfig getInstance() {
		return instance;
	}

	@Override
	public void setHome(String token, String path) throws AccessDeniedException, RepositoryException,
			DatabaseException {
		log.debug("setHome({}, {})", token, path);
		UserConfigModule ucm = ModuleManager.getUserConfigModule();
		ucm.setHome(token, path);
		log.debug("setHome: void");
	}

	@Override
	public UserConfig getConfig(String token) throws AccessDeniedException, RepositoryException, DatabaseException {
		log.debug("getConfig({})", token);
		UserConfigModule ucm = ModuleManager.getUserConfigModule();
		UserConfig userConfig = ucm.getConfig(token);
		log.debug("getConfig: {}", userConfig);
		return userConfig;
	}
}
