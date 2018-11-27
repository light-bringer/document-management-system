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

package com.ezdms.frontend.client.util.validator;

import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import eu.maydu.gwt.validation.client.ValidationAction;
import eu.maydu.gwt.validation.client.ValidationResult;
import eu.maydu.gwt.validation.client.Validator;
import eu.maydu.gwt.validation.client.i18n.StandardValidationMessages;
import eu.maydu.gwt.validation.client.i18n.ValidationMessages;

/**
 * IntegerMaxValidator
 *
 * @author jllort
 *
 */
public class IntegerMaxValidator extends Validator<IntegerMaxValidator> {

	private TextBoxBase text;
	private SuggestBox suggest;
	private int max;

	public IntegerMaxValidator(TextBoxBase text) {
		this(text, null);
	}

	public IntegerMaxValidator(TextBoxBase text, String customMsgKey) {
		this(text, false);
	}

	public IntegerMaxValidator(TextBoxBase text, int min) {
		this.text = text;
		this.max = min;
	}

	public IntegerMaxValidator(TextBoxBase text, int min, String customMsgKey) {
		this.text = text;
		this.max = min;
		this.setCustomMsgKey(customMsgKey);
	}

	public IntegerMaxValidator(TextBoxBase text, boolean preventsPropagationOfValidationChain) {
		this(text, preventsPropagationOfValidationChain, null);
	}

	public IntegerMaxValidator(TextBoxBase text, boolean preventsPropagationOfValidationChain, String customMsgKey) {
		super();
		this.setPreventsPropagationOfValidationChain(preventsPropagationOfValidationChain);
		if (text == null)
			throw new RuntimeException("text must not be null");
		this.text = text;
		this.setCustomMsgKey(customMsgKey);
	}

	public IntegerMaxValidator(SuggestBox suggest) {
		this(suggest, null);
	}

	public IntegerMaxValidator(SuggestBox suggest, String customMsgKey) {
		this(suggest, false);
		this.setCustomMsgKey(customMsgKey);
	}

	public IntegerMaxValidator(SuggestBox suggest, int min) {
		this(suggest, min, false);
	}


	public IntegerMaxValidator(SuggestBox suggest, boolean preventsPropagationOfValidationChain) {
		this(suggest, preventsPropagationOfValidationChain, null);
	}

	public IntegerMaxValidator(SuggestBox suggest, boolean preventsPropagationOfValidationChain, String customMsgKey) {
		super();
		this.setPreventsPropagationOfValidationChain(preventsPropagationOfValidationChain);
		if (suggest == null)
			throw new RuntimeException("suggest must not be null");
		this.suggest = suggest;
		this.setCustomMsgKey(customMsgKey);
	}

	public IntegerMaxValidator(SuggestBox suggest, int min, boolean preventsPropagationOfValidationChain) {
		this(suggest, min, preventsPropagationOfValidationChain, null);
	}

	public IntegerMaxValidator(SuggestBox suggest, int min, boolean preventsPropagationOfValidationChain, String customMsgKey) {
		super();
		this.setPreventsPropagationOfValidationChain(preventsPropagationOfValidationChain);
		if (suggest == null)
			throw new RuntimeException("suggest must not be null");
		this.suggest = suggest;
		this.max = min;
		this.setCustomMsgKey(customMsgKey);
	}

	@Override
	public ValidationResult validate(ValidationMessages allMessages) {
		StandardValidationMessages messages = allMessages.getStandardMessages();
		String str;
		if (text != null)
			str = text.getText();
		else str = suggest.getText();
		if (!isRequired() && str.equals(""))
			return null;
		str = str.trim();

		//Integer in range
		try {
			long value = Long.parseLong(str);
			if (value > this.max) {
				return new ValidationResult(getErrorMessage(allMessages, messages.validator_min()));
			}
		} catch (NumberFormatException ex) {
			return new ValidationResult(getErrorMessage(allMessages, messages.notAnInteger()));
		}

		return null;
	}

	public void invokeActions(ValidationResult result) {
		if (text != null) {
			for (ValidationAction<TextBoxBase> action : getFailureActions())
				action.invoke(result, text);
		} else {
			for (ValidationAction<SuggestBox> action : getFailureActions())
				action.invoke(result, suggest);
		}
	}
}
