package com.example.mathsquiz;



public class Questions{
    private String quest;
    private boolean result;
    private String url;
//    public Questions(){
//
//    }
//    public Questions(String quest,boolean result)
//    {
//        this.quest=quest;
//        this.result=result;
//    }
    public void setUrl(String url){
        this.url=url;
    }
    public String getUrl(){
        return url;
    }
    public String getQues_id()
    {
        return quest;
    }
    public void setQues_id(String quest)
    {
        this.quest=quest;
    }
    public boolean getResult()
    {
        return result;
    }
    public void setResult(boolean result)
    {
        this.result=result;
    }

}
