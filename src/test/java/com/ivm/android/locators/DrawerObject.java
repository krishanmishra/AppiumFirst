package com.ivm.android.locators;

public class DrawerObject {

	//locator class is public static final which means it can be accessed by all and cannot be changed.
	
	
	public final static String OpenDrawer = "//*[@content-desc='open_drawer']";
	public final static String home = "//android.widget.CheckedTextView[@text='Home']";
	public final static String appraisals = "//android.widget.CheckedTextView[@text='Appraisals']";
	public final static String inventory = "//android.widget.CheckedTextView[@text='Inventory']";
	public final static String settings = "//android.widget.CheckedTextView[@text='Settings']";
	public final static String send_Feedback = "//android.widget.CheckedTextView[@text='Send Feedback']";
	public final static String changeDealership = "//android.widget.CheckedTextView[@text='Change Dealership']";
	public final static String logout = "//android.widget.CheckedTextView[@text='Logout']";
	public final static String feedback_text = "com.ivm.appraisal:id/feedbackTextContainer";	
	public final static String inputFeedback = "com.ivm.appraisal:id/txtFeedback";
	public final static String sendFeedback = "com.ivm.appraisal:id/btn_send_feedback_bottom";
	public final static String inputCount = "com.ivm.appraisal:id/textinput_counter";
	
}
