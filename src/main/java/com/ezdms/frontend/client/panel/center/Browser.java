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

package com.ezdms.frontend.client.panel.center;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.ezdms.frontend.client.util.Util;
import com.ezdms.frontend.client.widget.filebrowser.FileBrowser;
import com.ezdms.frontend.client.widget.properties.TabMultiple;

/**
 * Browser panel
 *
 * @author jllort
 *
 */
public class Browser extends Composite {

	private final static int IE_SIZE_RECTIFICATION = (Util.getUserAgent().startsWith("ie") ? 2 : 0);
	private final static int SPLITTER_HEIGHT = 10;

	private VerticalSplitLayoutExtended verticalSplitLayoutPanel;
	private VerticalPanel tabPropertiesPanel;

	public FileBrowser fileBrowser;
	public TabMultiple tabMultiple;

	public int width = 0;
	public int height = 0;
	public int topHeight = 0;
	public int bottomHeight = 0;
	private int previousTopHeight = 0;

	/**
	 * Browser
	 */
	public Browser() {
		verticalSplitLayoutPanel = new VerticalSplitLayoutExtended(new VerticalResizeHandler() {
			@Override
			public void onResize(int topHeight, int bottomHeight) {
				resizePanels();
			}
		});
		fileBrowser = new FileBrowser();
		tabPropertiesPanel = new VerticalPanel();
		tabMultiple = new TabMultiple();

		tabPropertiesPanel.add(tabMultiple);
		tabPropertiesPanel.setStyleName("okm-Properties-Tab");

		verticalSplitLayoutPanel.getSplitPanel().addNorth(fileBrowser, 300);
		verticalSplitLayoutPanel.getSplitPanel().add(tabPropertiesPanel);

		initWidget(verticalSplitLayoutPanel);
	}

	/**
	 * Refresh language values
	 */
	public void langRefresh() {
		fileBrowser.langRefresh();
		tabMultiple.langRefresh();
	}

	/**
	 * Sets the size on initialization
	 *
	 * @param width The max width of the widget
	 * @param height The max height of the widget
	 */
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
		topHeight = (int) ((height - SPLITTER_HEIGHT) / 2);
		bottomHeight = height - (topHeight + SPLITTER_HEIGHT);
		verticalSplitLayoutPanel.setPixelSize(width, height);
		verticalSplitLayoutPanel.setSplitPosition(fileBrowser, topHeight, false);
		resize();
	}

	/**
	 * resize
	 */
	private void resize() {
		verticalSplitLayoutPanel.setWidth("" + width + "px");
		fileBrowser.setPixelSize(width, topHeight);
		int fileBrowserWidth = width - 2 + IE_SIZE_RECTIFICATION;
		int fileBrowserHeight = topHeight - 2 - FileBrowser.STATUS_SIZE + IE_SIZE_RECTIFICATION;
		if (fileBrowserWidth < 0) {
			fileBrowserWidth = 0;
		}
		if (fileBrowserHeight < 0) {
			fileBrowserHeight = 0;
		}
		// Resize the scroll panel on filebrowser
		// We substrat 2 pixels for fileBrowser pixels on width and the status fixed sixe on height 
		fileBrowser.table.setPixelSize(fileBrowserWidth, fileBrowserHeight);
		fileBrowser.table.fillWidth();
		// Resize the scroll panel on tab properties 
		// We substract 2 pixels for width and heigh generated by border line
		int tabMultipleWidth = width - 2;
		int tabMultipleHeight = bottomHeight - 2;
		if (tabMultipleWidth < 0) {
			tabMultipleWidth = 0;
		}
		if (tabMultipleHeight < 0) {
			tabMultipleHeight = 0;
		}
		tabMultiple.setPixelSize(tabMultipleWidth, tabMultipleHeight);
		tabPropertiesPanel.setPixelSize(width, bottomHeight);
	}

	/**
	 * expandFileBrowserView
	 */
	public void expandFileBrowserView() {
		previousTopHeight = topHeight;
		topHeight = height - SPLITTER_HEIGHT;
		bottomHeight = 0;
		resize();
		verticalSplitLayoutPanel.setSplitPosition(fileBrowser, topHeight, false);
	}

	/**
	 * expandTabView
	 */
	public void expandTabView() {
		previousTopHeight = topHeight;
		topHeight = 0;
		bottomHeight = height - SPLITTER_HEIGHT;
		resize();
		verticalSplitLayoutPanel.setSplitPosition(fileBrowser, topHeight, false);
	}

	/**
	 * restoreNormalView
	 */
	public void restoreNormalView() {
		topHeight = previousTopHeight;
		bottomHeight = height - (topHeight + SPLITTER_HEIGHT);
		resize();
		verticalSplitLayoutPanel.setSplitPosition(fileBrowser, topHeight, false);
	}

	/**
	 * setWidth
	 *
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
		resize();
	}

	/**
	 * Sets the panel width on resizing
	 */
	private void resizePanels() {
		topHeight = verticalSplitLayoutPanel.getTopHeight();
		bottomHeight = verticalSplitLayoutPanel.getBottomHeight();
		resize();
	}
}