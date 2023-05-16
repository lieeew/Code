package com.review;

/**
 * @Author: qxy
 * @Date: 2023/2/4 11
 * @Description:
 */
public class NiukeTest {
    /*
    接口可以多继承
     */

}

class Print{
    static boolean out(char c){
        System.out.print(c);
        return true;
    }
    public static void main(String[] argv){
        int i = 0;
        for(out('A');out('B') && (i<2);out('C')){
            i++;
            out('D');
        }

    }
}