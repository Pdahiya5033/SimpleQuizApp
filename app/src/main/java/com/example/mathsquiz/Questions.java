package com.example.mathsquiz;



public class Questions{
    private int ques_id;
    private boolean result;
    public Questions(int ques_id,boolean result)
    {
        this.ques_id=ques_id;
        this.result=result;
    }
    public int getQues_id()
    {
        return ques_id;
    }
    public void setQues_id(int ques_id)
    {
        this.ques_id=ques_id;
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
