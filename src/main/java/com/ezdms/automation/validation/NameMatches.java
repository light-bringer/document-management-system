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

package com.ezdms.automation.validation;

import java.util.Map;

import com.ezdms.automation.AutomationUtils;
import com.ezdms.automation.Validation;
import com.ezdms.dao.bean.Automation;
import com.ezdms.dao.bean.NodeDocument;
import com.ezdms.dao.bean.NodeFolder;
import com.ezdms.dao.bean.NodeMail;

import net.xeoh.plugins.base.annotations.PluginImplementation;

@PluginImplementation
public class NameMatches implements Validation {

	@Override
	public boolean isValid(Map<String, Object> env, Object... params) throws Exception {
		String str = AutomationUtils.getString(0, params);
		Object node = AutomationUtils.getNode(env);

		if (node != null) {
			if (node instanceof NodeDocument) {
				return ((NodeDocument) node).getName().matches(str);
			} else if (node instanceof NodeFolder) {
				return ((NodeFolder) node).getName().matches(str);
			} else if (node instanceof NodeMail) {
				return ((NodeMail) node).getName().matches(str);
			} 
		}

		return false;
	}

	@Override
	public boolean hasPost() {
		return true;
	}

	@Override
	public boolean hasPre() {
		return true;
	}

	@Override
	public String getName() {
		return "NameMatches";
	}

	@Override
	public String getParamType00() {
		return Automation.PARAM_TYPE_TEXT;
	}

	@Override
	public String getParamSrc00() {
		return Automation.PARAM_SOURCE_EMPTY;
	}

	@Override
	public String getParamDesc00() {
		return "String";
	}

	@Override
	public String getParamType01() {
		return Automation.PARAM_TYPE_EMPTY;
	}

	@Override
	public String getParamSrc01() {
		return Automation.PARAM_SOURCE_EMPTY;
	}

	@Override
	public String getParamDesc01() {
		return "";
	}

	@Override
	public String getParamType02() {
		return Automation.PARAM_TYPE_EMPTY;
	}

	@Override
	public String getParamSrc02() {
		return Automation.PARAM_SOURCE_EMPTY;
	}

	@Override
	public String getParamDesc02() {
		return "";
	}
}
