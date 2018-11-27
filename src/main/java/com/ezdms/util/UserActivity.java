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

package com.ezdms.util;

import com.ezdms.core.Config;
import com.ezdms.core.DatabaseException;
import com.ezdms.dao.ActivityDAO;
import com.ezdms.dao.DashboardActivityDAO;
import com.ezdms.dao.bean.Activity;
import com.ezdms.dao.bean.DashboardActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author pavila
 */
public class UserActivity {
	private static Logger log = LoggerFactory.getLogger(UserActivity.class);
	private static List<String> dashboardActions = new ArrayList<String>();

	static {
		dashboardActions.add("CREATE_DOCUMENT");
		dashboardActions.add("CHECKIN_DOCUMENT");
		dashboardActions.add("GET_DOCUMENT_CONTENT");
		dashboardActions.add("CREATE_MAIL_ATTACHMENT");
		dashboardActions.add("CREATE_MAIL");
	}

	/**
	 * Log activity
	 *
	 * @param user User id who generated the activity.
	 * @param action Which action is associated with the activity.
	 * @param item Unique node identifier if this activity is node related, or another entity identifier.
	 * @param params Other activity related parameters.
	 */
	public static void log(String user, String action, String item, String path, String params) {
		try {
			Activity act = new Activity();
			act.setDate(Calendar.getInstance());
			act.setUser(user);
			act.setAction(action);
			act.setItem(item);
			act.setPath(path);
			act.setParams(params);

			if (log.isDebugEnabled()) {
				log.debug(act.toString());
			}

			// Only log activity if match pattern
			for (String actPattern : Config.ACTIVITY_LOG_ACTIONS) {
				if (action.matches(actPattern)) {
					ActivityDAO.create(act);
					break;
				}
			}

			// Dashboard hack
			if (dashboardActions.contains(action)) {
				DashboardActivity dashAct = new DashboardActivity();
				dashAct.setDate(act.getDate());
				dashAct.setUser(act.getUser());
				dashAct.setAction(act.getAction());
				dashAct.setItem(act.getItem());
				dashAct.setPath(act.getPath());
				DashboardActivityDAO.create(dashAct);
			}
		} catch (DatabaseException e) {
			log.error(e.getMessage());
		}
	}
}
