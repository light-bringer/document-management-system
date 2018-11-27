/**
 * ezDMS, Open Document Management System (http://www.ezdms.com)
 * Copyright (c) 2006-2017  Paco Avila & Josep Llort
 * <p>
 * No bytes were intentionally harmed during the development of this application.
 * <p>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General License for more details.
 * <p>
 * You should have received a copy of the GNU General License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.ezdms.frontend.client.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * OKMBundleResources
 *
 * @author jllort
 *
 */
public interface OKMBundleResources extends ClientBundle {
	OKMBundleResources INSTANCE = GWT.create(OKMBundleResources.class);

	@Source("com/ezdms/frontend/public/img/icon/actions/delete.gif")
	ImageResource deleteIcon();

	@Source("com/ezdms/frontend/public/img/icon/actions/clean.png")
	ImageResource cleanIcon();

	@Source("com/ezdms/frontend/public/img/icon/stackpanel/book_open.gif")
	ImageResource bookOpenIcon();

	@Source("com/ezdms/frontend/public/img/icon/stackpanel/table_key.gif")
	ImageResource tableKeyIcon();

	@Source("com/ezdms/frontend/public/img/icon/toolbar/user.png")
	ImageResource userIcon();

	@Source("com/ezdms/frontend/public/img/icon/toolbar/mail.png")
	ImageResource mailIcon();

	@Source("com/ezdms/frontend/public/img/icon/toolbar/news.png")
	ImageResource newsIcon();

	@Source("com/ezdms/frontend/public/img/icon/toolbar/general.png")
	ImageResource generalIcon();

	@Source("com/ezdms/frontend/public/img/icon/toolbar/workflow.png")
	ImageResource workflowIcon();

	@Source("com/ezdms/frontend/public/img/icon/toolbar/keyword_map.png")
	ImageResource keywordMapIcon();

	@Source("com/ezdms/frontend/public/img/icon/actions/add_folder.gif")
	ImageResource createFolder();

	@Source("com/ezdms/frontend/public/img/icon/actions/add_folder_disabled.gif")
	ImageResource createFolderDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/folder_find.gif")
	ImageResource findFolder();

	@Source("com/ezdms/frontend/public/img/icon/actions/folder_find_disabled.gif")
	ImageResource findFolderDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/document_find.png")
	ImageResource findDocument();

	@Source("com/ezdms/frontend/public/img/icon/actions/document_find_disabled.png")
	ImageResource findDocumentDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/lock.gif")
	ImageResource lock();

	@Source("com/ezdms/frontend/public/img/icon/actions/lock_disabled.gif")
	ImageResource lockDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/unlock.gif")
	ImageResource unLock();

	@Source("com/ezdms/frontend/public/img/icon/actions/unlock_disabled.gif")
	ImageResource unLockDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/add_document.gif")
	ImageResource addDocument();

	@Source("com/ezdms/frontend/public/img/icon/actions/add_document_disabled.gif")
	ImageResource addDocumentDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/delete.gif")
	ImageResource delete();

	@Source("com/ezdms/frontend/public/img/icon/actions/delete_disabled.gif")
	ImageResource deleteDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/checkout.gif")
	ImageResource checkout();

	@Source("com/ezdms/frontend/public/img/icon/actions/checkout_disabled.gif")
	ImageResource checkoutDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/checkin.gif")
	ImageResource checkin();

	@Source("com/ezdms/frontend/public/img/icon/actions/checkin_disabled.gif")
	ImageResource checkinDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/cancel_checkout.gif")
	ImageResource cancelCheckout();

	@Source("com/ezdms/frontend/public/img/icon/actions/cancel_checkout_disabled.gif")
	ImageResource cancelCheckoutDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/download.gif")
	ImageResource download();

	@Source("com/ezdms/frontend/public/img/icon/actions/download_disabled.gif")
	ImageResource downloadDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/download_pdf.gif")
	ImageResource downloadPdf();

	@Source("com/ezdms/frontend/public/img/icon/actions/download_pdf_disabled.gif")
	ImageResource downloadPdfDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/add_property_group.gif")
	ImageResource addPropertyGroup();

	@Source("com/ezdms/frontend/public/img/icon/actions/add_property_group_disabled.gif")
	ImageResource addPropertyGroupDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/remove_property_group.gif")
	ImageResource removePropertyGroup();

	@Source("com/ezdms/frontend/public/img/icon/actions/remove_property_group_disabled.gif")
	ImageResource removePropertyGroupDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/start_workflow.gif")
	ImageResource startWorkflow();

	@Source("com/ezdms/frontend/public/img/icon/actions/start_workflow_disabled.gif")
	ImageResource startWorkflowDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/add_subscription.gif")
	ImageResource addSubscription();

	@Source("com/ezdms/frontend/public/img/icon/actions/add_subscription_disabled.gif")
	ImageResource addSubscriptionDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/remove_subscription.gif")
	ImageResource removeSubscription();

	@Source("com/ezdms/frontend/public/img/icon/actions/remove_subscription_disabled.gif")
	ImageResource removeSubscriptionDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/propose_subscription.png")
	ImageResource proposeSubscription();

	@Source("com/ezdms/frontend/public/img/icon/actions/bookmark_go.gif")
	ImageResource home();

	@Source("com/ezdms/frontend/public/img/icon/actions/bookmark_go_disabled.gif")
	ImageResource homeDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/refresh.gif")
	ImageResource refresh();

	@Source("com/ezdms/frontend/public/img/icon/actions/refresh_disabled.gif")
	ImageResource refreshDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/scanner_disabled.gif")
	ImageResource scannerDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/scanner.gif")
	ImageResource scanner();

	@Source("com/ezdms/frontend/public/img/icon/actions/upload_disabled.gif")
	ImageResource uploaderDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/upload.gif")
	ImageResource uploader();

	@Source("com/ezdms/frontend/public/img/icon/chat/chat_disconnected.png")
	ImageResource chatDisconnected();

	@Source("com/ezdms/frontend/public/img/icon/chat/chat_connected.png")
	ImageResource chatConnected();

	@Source("com/ezdms/frontend/public/img/icon/chat/new_chat_room.png")
	ImageResource newChatRoom();

	@Source("com/ezdms/frontend/public/img/icon/chat/add_user.png")
	ImageResource addUserToChatRoom();

	@Source("com/ezdms/frontend/public/img/icon/connect.gif")
	ImageResource ezdmsConnected();

	@Source("com/ezdms/frontend/public/img/icon/user_repository.gif")
	ImageResource repositorySize();

	@Source("com/ezdms/frontend/public/img/icon/subscribed.gif")
	ImageResource subscribed();

	@Source("com/ezdms/frontend/public/img/icon/news_alert.gif")
	ImageResource newsAlert();

	@Source("com/ezdms/frontend/public/img/icon/news.gif")
	ImageResource news();

	@Source("com/ezdms/frontend/public/img/icon/workflow_tasks.gif")
	ImageResource workflowTasks();

	@Source("com/ezdms/frontend/public/img/icon/workflow_tasks_alert.gif")
	ImageResource workflowTasksAlert();

	@Source("com/ezdms/frontend/public/img/icon/workflow_pooled_tasks.gif")
	ImageResource workflowPooledTasks();

	@Source("com/ezdms/frontend/public/img/icon/workflow_pooled_tasks_alert.gif")
	ImageResource workflowPooledTasksAlert();

	@Source("com/ezdms/frontend/public/img/icon/warning.gif")
	ImageResource warning();

	@Source("com/ezdms/frontend/public/img/icon/toolbar/separator.gif")
	ImageResource separator();

	@Source("com/ezdms/frontend/public/img/zoom_out.gif")
	ImageResource zoomOut();

	@Source("com/ezdms/frontend/public/img/zoom_in.gif")
	ImageResource zoomIn();

	@Source("com/ezdms/frontend/public/img/viewed.gif")
	ImageResource viewed();

	@Source("com/ezdms/frontend/public/img/viewed_pending.gif")
	ImageResource pending();

	@Source("com/ezdms/frontend/public/img/feed.png")
	ImageResource feed();

	@Source("com/ezdms/frontend/public/img/icon/loaded.gif")
	ImageResource loadedIcon();

	@Source("com/ezdms/frontend/public/img/icon/loaded_disabled.gif")
	ImageResource loadedDisabledIcon();

	@Source("com/ezdms/frontend/public/img/icon/loaded_error.gif")
	ImageResource loadedErrorIcon();

	@Source("com/ezdms/frontend/public/img/icon/security/add.gif")
	ImageResource add();

	@Source("com/ezdms/frontend/public/img/icon/security/remove.gif")
	ImageResource remove();

	@Source("com/ezdms/frontend/public/img/icon/quota/quota1.gif")
	ImageResource quota1();

	@Source("com/ezdms/frontend/public/img/icon/quota/quota2.gif")
	ImageResource quota2();

	@Source("com/ezdms/frontend/public/img/icon/quota/quota3.gif")
	ImageResource quota3();

	@Source("com/ezdms/frontend/public/img/icon/quota/quota4.gif")
	ImageResource quota4();

	@Source("com/ezdms/frontend/public/img/icon/quota/quota5.gif")
	ImageResource quota5();

	@Source("com/ezdms/frontend/public/img/icon/quota/quota6.gif")
	ImageResource quota6();

	@Source("com/ezdms/frontend/public/img/icon/search/calendar.gif")
	ImageResource calendar();

	@Source("com/ezdms/frontend/public/img/icon/search/calendar_disabled.gif")
	ImageResource calendarDisabled();

	@Source("com/ezdms/frontend/public/img/icon/security/yes.gif")
	ImageResource yes();

	@Source("com/ezdms/frontend/public/img/icon/security/no.gif")
	ImageResource no();

	@Source("com/ezdms/frontend/public/img/icon/actions/comment_edit.gif")
	ImageResource noteEdit();

	@Source("com/ezdms/frontend/public/img/icon/actions/comment_delete.gif")
	ImageResource noteDelete();

	@Source("com/ezdms/frontend/public/img/icon/search/folder_explore.gif")
	ImageResource folderExplorer();

	@Source("com/ezdms/frontend/public/img/indicator.gif")
	ImageResource indicator();

	@Source("com/ezdms/frontend/public/img/icon/actions/share_query.gif")
	ImageResource sharedQuery();

	@Source("com/ezdms/frontend/public/img/icon/actions/printer.png")
	ImageResource print();

	@Source("com/ezdms/frontend/public/img/icon/actions/printer_disabled.png")
	ImageResource printDisabled();

	@Source("com/ezdms/frontend/public/img/icon/editor/justifyCenter.gif")
	ImageResource justifyCenter();

	@Source("com/ezdms/frontend/public/img/icon/editor/justify.gif")
	ImageResource justify();

	@Source("com/ezdms/frontend/public/img/icon/editor/justifyLeft.gif")
	ImageResource justifyLeft();

	@Source("com/ezdms/frontend/public/img/icon/editor/justifyRight.gif")
	ImageResource justifyRight();

	@Source("com/ezdms/frontend/public/img/icon/editor/bold.gif")
	ImageResource bold();

	@Source("com/ezdms/frontend/public/img/icon/editor/italic.gif")
	ImageResource italic();

	@Source("com/ezdms/frontend/public/img/icon/editor/underline.gif")
	ImageResource underline();

	@Source("com/ezdms/frontend/public/img/icon/editor/stroke.gif")
	ImageResource stroke();

	@Source("com/ezdms/frontend/public/img/icon/editor/subscript.gif")
	ImageResource subScript();

	@Source("com/ezdms/frontend/public/img/icon/editor/superscript.gif")
	ImageResource superScript();

	@Source("com/ezdms/frontend/public/img/icon/editor/unordered.gif")
	ImageResource unOrdered();

	@Source("com/ezdms/frontend/public/img/icon/editor/ordered.gif")
	ImageResource ordered();

	@Source("com/ezdms/frontend/public/img/icon/editor/identLeft.gif")
	ImageResource identLeft();

	@Source("com/ezdms/frontend/public/img/icon/editor/identRight.gif")
	ImageResource identRight();

	@Source("com/ezdms/frontend/public/img/icon/editor/createEditorLink.gif")
	ImageResource createEditorLink();

	@Source("com/ezdms/frontend/public/img/icon/editor/breakEditorLink.gif")
	ImageResource breakEditorLink();

	@Source("com/ezdms/frontend/public/img/icon/editor/line.gif")
	ImageResource line();

	@Source("com/ezdms/frontend/public/img/icon/editor/html.gif")
	ImageResource html();

	@Source("com/ezdms/frontend/public/img/icon/editor/picture.gif")
	ImageResource picture();

	@Source("com/ezdms/frontend/public/img/icon/editor/removeFormat.gif")
	ImageResource removeFormat();

	@Source("com/ezdms/frontend/public/img/icon/actions/folder_edit.png")
	ImageResource folderEdit();

	@Source("com/ezdms/frontend/public/img/icon/actions/new_record.png")
	ImageResource newRecord();

	@Source("com/ezdms/frontend/public/img/icon/actions/database_record.png")
	ImageResource databaseRecord();

	@Source("com/ezdms/frontend/public/img/icon/actions/search.png")
	ImageResource search();

	@Source("com/ezdms/frontend/public/img/icon/actions/search_disabled.png")
	ImageResource searchDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/application_resize.png")
	ImageResource splitterResize();

	@Source("com/ezdms/frontend/public/img/icon/actions/application_resize_disabled.png")
	ImageResource splitterResizeDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/arrow_up.png")
	ImageResource arrowUp();

	@Source("com/ezdms/frontend/public/img/icon/actions/massive_actions.png")
	ImageResource massive();

	@Source("com/ezdms/frontend/public/img/icon/actions/arrow_down.png")
	ImageResource arrowDown();

	@Source("com/ezdms/frontend/public/img/icon/actions/find.png")
	ImageResource find();

	@Source("com/ezdms/frontend/public/img/icon/actions/find_disabled.png")
	ImageResource findDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/similar_find.png")
	ImageResource findSimilarDocument();

	@Source("com/ezdms/frontend/public/img/icon/actions/folder.png")
	ImageResource folder();

	@Source("com/ezdms/frontend/public/img/icon/actions/folder_disabled.png")
	ImageResource folderDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/document.png")
	ImageResource document();

	@Source("com/ezdms/frontend/public/img/icon/actions/document_disabled.png")
	ImageResource documentDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/mail.png")
	ImageResource mail();

	@Source("com/ezdms/frontend/public/img/icon/actions/mail_disabled.png")
	ImageResource mailDisabled();

	@Source("com/ezdms/frontend/public/img/icon/search/resultset_next.gif")
	ImageResource next();

	@Source("com/ezdms/frontend/public/img/icon/search/resultset_next_disabled.gif")
	ImageResource nextDisabled();

	@Source("com/ezdms/frontend/public/img/icon/search/resultset_previous.gif")
	ImageResource previous();

	@Source("com/ezdms/frontend/public/img/icon/search/resultset_previous_disabled.gif")
	ImageResource previousDisabled();

	@Source("com/ezdms/frontend/public/img/icon/search/goto_end.gif")
	ImageResource gotoEnd();

	@Source("com/ezdms/frontend/public/img/icon/search/goto_end_disabled.gif")
	ImageResource gotoEndDisabled();

	@Source("com/ezdms/frontend/public/img/icon/search/goto_start.gif")
	ImageResource gotoStart();

	@Source("com/ezdms/frontend/public/img/icon/search/goto_start_disabled.gif")
	ImageResource gotoStartDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/filter.png")
	ImageResource filter();

	@Source("com/ezdms/frontend/public/img/icon/actions/export_csv.png")
	ImageResource exportCSV();

	@Source("com/ezdms/frontend/public/img/icon/actions/options.png")
	ImageResource options();	
	
	@Source("com/ezdms/frontend/public/img/icon/actions/omr.png")
	ImageResource omr();
	
	@Source("com/ezdms/frontend/public/img/icon/actions/omr_disabled.png")
	ImageResource omrDisabled();

	@Source("com/ezdms/frontend/public/img/icon/actions/clipboard.png")
	ImageResource clipboard();

	@Source("com/ezdms/frontend/public/img/icon/actions/clipboard_small.png")
	ImageResource clipboardSmall();
}
