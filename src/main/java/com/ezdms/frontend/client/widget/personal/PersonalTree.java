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

package com.ezdms.frontend.client.widget.personal;

import com.ezdms.frontend.client.Main;
import com.ezdms.frontend.client.bean.GWTFolder;
import com.ezdms.frontend.client.constants.ui.UIDesktopConstants;
import com.ezdms.frontend.client.widget.MenuPopup;
import com.ezdms.frontend.client.widget.foldertree.FolderSelectPopup;
import com.ezdms.frontend.client.widget.foldertree.FolderTree;

/**
 * Personal tree
 *
 * @author jllort
 *
 */
public class PersonalTree extends FolderTree {

	/**
	 * Inits on first load
	 */
	public void init() {
		menuPopup = new MenuPopup(new PersonalMenu());
		menuPopup.setStyleName("okm-MenuPopup");

		folderRoot = Main.get().personalRootFolder;

		// Sets the context on list context search values
		Main.get().repositoryContext.setContextPersonal(folderRoot.getPath());
		Main.get().mainPanel.search.searchBrowser.searchIn.setContextValue(folderRoot.getPath(), UIDesktopConstants.NAVIGATOR_PERSONAL);

		actualItem.setUserObject(folderRoot);
		evaluesFolderIcon(actualItem);
		actualItem.setState(true);
		rootItem = actualItem;  // Preserves actualItem value
	}

	/**
	 * Move folder on file browser ( only trash mode )
	 */
	public void move() {
		GWTFolder folderToRestore = (GWTFolder) actualItem.getUserObject();
		folderSelectPopup.setEntryPoint(FolderSelectPopup.ENTRYPOINT_MY_DOCUMENTS);
		folderSelectPopup.setToMove(folderToRestore);
		showDirectorySelectPopup();
		hideMenuPopup();
	}

	/**
	 * Copy folder on file browser ( only trash mode )
	 */
	public void copy() {
		GWTFolder folderToCopy = (GWTFolder) actualItem.getUserObject();
		folderSelectPopup.setEntryPoint(FolderSelectPopup.ENTRYPOINT_MY_DOCUMENTS);
		folderSelectPopup.setToCopy(folderToCopy);
		showDirectorySelectPopup();
		hideMenuPopup();
	}
}