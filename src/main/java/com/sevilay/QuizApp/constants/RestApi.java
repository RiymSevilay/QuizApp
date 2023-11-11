package com.sevilay.QuizApp.constants;

public class RestApi {
    private static final String VERSION = "/v1";
    private static final String DEV = "/dev";
    private static final String TEST = "/test";
    private static final String PROD = "/prod";
    private static final String ROOT = VERSION + DEV;
    public static final String QUESTION = ROOT + "/question";
    public static final String ANSWER = ROOT + "/answer";
    public static final String SAVE = "/save";
    public static final String SAVEALL = "/saveall";
    private static final String UPDATE = "/update";
    private static final String DELETE = "/delete";
    public static final String FINDALL = "/findall";
    public static final String FINDBYID = "/findbyid";
    public static final String FINDALLWITHANSWERDATA = "/find_all_with_answer_data";
    public static final String FINDBYIDWITHANSWERDATA = "/find_by_id_with_answer_data";
}
