package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Sanya on 16.10.2016.
 */
public class SubSolution extends Solution
{
    private SubSolution(Boolean B) { super(B); } // Тут ругается на все переменные
    private SubSolution(boolean b) { super(b); } // конструкторов. Говорит
    private SubSolution(String s) { super(s); }  // Cannot resolve method 'super(...)
    public SubSolution(byte b) { super(b); }
    public SubSolution(short s) { super(s); }
    public SubSolution(int i) { super(i); }
    protected SubSolution(long l) { super(l); }
    protected SubSolution(float f) { super(f);}
    protected SubSolution(double d) { super(d); }
    SubSolution(Short S) { super(S); }
    SubSolution(Integer I) { super(I); }
    SubSolution(Long L) { super(L); }

}
