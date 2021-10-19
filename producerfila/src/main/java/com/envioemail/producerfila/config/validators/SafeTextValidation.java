package com.envioemail.producerfila.config.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Locale;
import java.util.regex.Pattern;

public class SafeTextValidation implements ConstraintValidator<SafeTextValidator, String> {

    private boolean isRequired;

    private static Pattern[] patterns = new Pattern[]{

            Pattern.compile("(%3c).*.(%3e)", Pattern.CASE_INSENSITIVE),
            Pattern.compile("(%3e).*.(%3c)", Pattern.CASE_INSENSITIVE),
            Pattern.compile("&lt", Pattern.CASE_INSENSITIVE),
            Pattern.compile("&gt", Pattern.CASE_INSENSITIVE),
            Pattern.compile("&#", Pattern.CASE_INSENSITIVE),
            Pattern.compile("!--#exec", Pattern.CASE_INSENSITIVE),
            Pattern.compile("&quot;", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\<.*?\\>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("javascript", Pattern.CASE_INSENSITIVE),
            Pattern.compile("(document)[//.]+.*", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<?php>(.*?)</php>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
            Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
            Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL)
    };


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (isRequired) {
            if (value == null) return false;
        } else {
            if (value == null) return false;
        }
        boolean isXss = false;
        for (Pattern scriptPattern : patterns) {
            isXss = scriptPattern.matcher(value.trim().toLowerCase()).find();
            if (isXss) {
                break;
            }
        }
        return isXss ? false : true;
    }
}
