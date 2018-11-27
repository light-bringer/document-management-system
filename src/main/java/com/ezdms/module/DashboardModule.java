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

package com.ezdms.module;

import com.ezdms.bean.DashboardDocumentResult;
import com.ezdms.bean.DashboardFolderResult;
import com.ezdms.bean.DashboardMailResult;
import com.ezdms.core.AccessDeniedException;
import com.ezdms.core.DatabaseException;
import com.ezdms.core.ParseException;
import com.ezdms.core.RepositoryException;
import com.ezdms.dao.bean.QueryParams;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public interface DashboardModule {

	/**
	 * Get list of locked documents by user
	 */
	public List<DashboardDocumentResult> getUserLockedDocuments(String token) throws AccessDeniedException, RepositoryException,
			DatabaseException;

	/**
	 * Get list of checked-out documents by user
	 */
	public List<DashboardDocumentResult> getUserCheckedOutDocuments(String token) throws AccessDeniedException, RepositoryException,
			DatabaseException;

	/**
	 * Get user subscribed documents
	 */
	public List<DashboardDocumentResult> getUserSubscribedDocuments(String token) throws AccessDeniedException, RepositoryException,
			DatabaseException;

	/**
	 * Get user subscribed folders
	 */
	public List<DashboardFolderResult> getUserSubscribedFolders(String token) throws AccessDeniedException, RepositoryException,
			DatabaseException;

	/**
	 * Get user last uploaded documents 
	 */
	public List<DashboardDocumentResult> getUserLastUploadedDocuments(String token) throws AccessDeniedException, RepositoryException,
			DatabaseException;

	/**
	 * Get user last modified documents 
	 */
	public List<DashboardDocumentResult> getUserLastModifiedDocuments(String token) throws AccessDeniedException, RepositoryException,
			DatabaseException;

	/**
	 * Get user last downloaded documents
	 */
	public List<DashboardDocumentResult> getUserLastDownloadedDocuments(String token) throws AccessDeniedException, RepositoryException,
			DatabaseException;

	/**
	 * Get user last imported mails
	 */
	public List<DashboardMailResult> getUserLastImportedMails(String token) throws AccessDeniedException, RepositoryException,
			DatabaseException;

	/**
	 * Get user last imported mail attachments
	 */
	public List<DashboardDocumentResult> getUserLastImportedMailAttachments(String token) throws AccessDeniedException, RepositoryException,
			DatabaseException;

	/**
	 * Get user documents size
	 */
	public long getUserDocumentsSize(String token) throws AccessDeniedException, RepositoryException, DatabaseException;

	/**
	 * Get user searchs
	 */
	public List<QueryParams> getUserSearchs(String token) throws AccessDeniedException, RepositoryException, DatabaseException;

	/**
	 * Find
	 */
	public List<DashboardDocumentResult> find(String token, int pqId) throws IOException, ParseException, AccessDeniedException,
			RepositoryException, DatabaseException;

	/**
	 * Get last week top downloaded documents
	 */
	public List<DashboardDocumentResult> getLastWeekTopDownloadedDocuments(String token) throws AccessDeniedException,
			RepositoryException, DatabaseException;

	/**
	 * Get last month downloaded documents
	 */
	public List<DashboardDocumentResult> getLastMonthTopDownloadedDocuments(String token) throws AccessDeniedException,
			RepositoryException, DatabaseException;

	/**
	 * Get last week top modified documents
	 */
	public List<DashboardDocumentResult> getLastWeekTopModifiedDocuments(String token) throws AccessDeniedException,
			RepositoryException, DatabaseException;

	/**
	 * Get las month top modified documentd
	 */
	public List<DashboardDocumentResult> getLastMonthTopModifiedDocuments(String token) throws AccessDeniedException,
			RepositoryException, DatabaseException;

	/**
	 * Get last modified documents
	 */
	public List<DashboardDocumentResult> getLastModifiedDocuments(String token) throws AccessDeniedException, RepositoryException,
			DatabaseException;

	/**
	 * Get last uploaded documents
	 */
	public List<DashboardDocumentResult> getLastUploadedDocuments(String token) throws AccessDeniedException, RepositoryException,
			DatabaseException;

	/**
	 * Visite node
	 */
	public void visiteNode(String token, String source, String node, Calendar date) throws AccessDeniedException, RepositoryException,
			DatabaseException;
}
