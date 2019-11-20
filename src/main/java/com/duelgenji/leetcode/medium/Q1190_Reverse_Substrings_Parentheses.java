package com.duelgenji.leetcode.medium;


import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.Stack;

//1190. Reverse Substrings Between Each Pair of Parentheses
public class Q1190_Reverse_Substrings_Parentheses {

    //question:
    //https://leetcode.com/contest/weekly-contest-154/problems/reverse-substrings-between-each-pair-of-parentheses/


    //by knight
    //前提 没有判断对称括号
    //思路 获取最右边的左括号，记录并且往右寻找第一个右括号，然后反转其中的文字并且括号去掉与其他字段拼接
    public static String reverseMostInsideParentheses(String s){

//        System.out.println("content in :" + content);

        String str;
        int l = s.lastIndexOf("(");
        int r = s.indexOf(")",l);

        if(l<0){
            return s;
        }else{
//            System.out.println(content.substring(0,l));
//            System.out.println(content.substring(l+1,r));
//            System.out.println(content.substring(r+1));
            str = s.substring(0,l) + new StringBuilder(s.substring(l+1,r)).reverse().toString() + s.substring(r+1);
        }

//        System.out.println("content out :" + str);


        if(str.contains("(")){
            str = reverseMostInsideParentheses(str);
        }
        return str;
    }


    //online stack solution 没有比自己写的更快
    public static String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> opened = new Stack<>();
        int[] pair = new int[n];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(')
                opened.push(i);
            if (s.charAt(i) == ')') {
                int j = opened.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, d = 1; i < n; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "(asdasd)1234";
        String s1000="((e(f()(((()vbl))s)i(hbo)(j((emr(g((dyvz(j(k))qn(r(s))(by()lg)(z)(v))po(ri))uq)(())(i)((((joovdi(r(hov)tk)ycpv))(uu)n)((pc(kmhzko(h)j())x)idpe(tf(a()j)lcszq)el)e)(q)s)))h((()hq))ty)z((r)(etuimhqk(vc)o(x(eavtr)c())gr(iaeh))(uijw)ribmj((nmxndbljlphzisqms)q)hp(()(((k)y(qfjwg)t(v)rye(mm)jonu()gwv))(()dtc(nf)a)q)(l(g)ls)(elxperab)ugnutxcd)ucbet)joc(e(ka)))ayudqadlo()(s(rkyp)u)uoukgnkbxvgqpm()u()ofcoobafiyurfx()bwcnlgnjieh((up)lfo(nfzid(wpcttauya((d)(lt(s)fa(o))it(gn)(imb(rp(b)v(w((kt())qcia(lsu(nx)biucqc)g(rjvzm)))(af(p)(km)c(ozd)i(a(ufpmqyty)gd(unoo()ncwc)b(buj)s))(z))yh)goq(u)((kn)kpa)kfe(r(aurgx)ke)xpa(lofufr((r())d)(wlw(ew)))))(k)()(lwq)wksx))pavt(w)n(jn)gewybef(t)djbyk((b))lkqiyxo(on)yckdkzfmradisc()(o)qdl((asms(c((t)zwcc)g)(pc)()e((((rlm(jegb)zcu((bw(mbps(g)n)fgkjkb(fp(vm(tzsp)(t((t)d()c(x(ktviam(e((r)xfktm)vc(w)hi(ylenyelvde(lu((xce)ofbiv)je)t((oqp)jng)vr)o)ctdkzogm((km)nk))gv)xjueo(qmclm()r)ttg))c)wv())qlrs)(sl(fo(e))nxsjmgxt)nyg(dn()((((ri(b(as()qyg)amcy)vk()()((ny(()(x(gu(q)lxx(m()))))))))))))))))))";


        long startTime = Calendar.getInstance().getTimeInMillis();



//        reverseMostInsideParentheses(s1000);
        reverseParentheses(s1000);

        long endTime = Calendar.getInstance().getTimeInMillis();
        long diffTime = (endTime - startTime);


        System.out.println("cost :"+diffTime + "ms");

    }


    //判断是否 成双成对 简易版 只有验证了左右数量 没有判断是否一一对应
    public static boolean isPairParentheses(String content){
        int left_parenthesis = 0;
        int right_parenthesis = 0;

        left_parenthesis = StringUtils.countMatches(content,"(");
        right_parenthesis = StringUtils.countMatches(content,")");

        return left_parenthesis == right_parenthesis;
    }


}
