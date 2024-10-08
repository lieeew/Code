package com.leikooo.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/1/31 18
 * @Description: 正则表达式地底层实现
 */
public class RegTheory {
    public static void main(String[] args) {
        String content = "Java是一种广泛使用的计算机编程语言，拥有跨平台、面向对象、泛型编程的特性，广泛应用于企业级Web应用开发和移动应用开发。\n" +
                "\n" +
                "任职于Sun微系统的詹姆斯·高斯林等人于1990年代初开发Java语言的雏形，最初被命名为Oak，目标设置在家用电器等小型系统的编程语言，应用在电视机、电话、闹钟、烤面包机等家用电器的控制和通信。由于这些智能化家电的市场需求没有预期的高，Sun微系统放弃了该项计划。随着1990年代互联网的发展，Sun微系统看见Oak在互联网上应用的前景，于是改造了Oak，于1995年5月以Java的名称正式发布。Java伴随着互联网的迅猛发展而发展，逐渐成为重要的网络编程语言。\n" +
                "\n" +
                "Java编程语言的风格十分接近C++语言。继承了C++语言面向对象技术的核心，舍弃了容易引起错误的指针，以引用取代；移除了C++中的运算符重载和多重继承特性，用接口取代；增加垃圾回收器功能。在Java SE 1.5版本中引入了泛型编程、类型安全的枚举、不定长参数和自动装/拆箱特性。Sun微系统对Java语言的解释是：“Java编程语言是个简单、面向对象、分布式、解释性、健壮、安全、与系统无关、可移植、高性能、多线程和动态的语言”。\n" +
                "\n" +
                "Java不同于一般的编译语言或解释型语言。它首先将源代码编译成字节码，再依赖各种不同平台上的虚拟机来解释执行字节码，从而具有“一次编写，到处运行”的跨平台特性。在早期JVM中，这在一定程度上降低了Java程序的运行效率。但在J2SE1.4.2发布后，Java的执行速度有了大幅提升。\n" +
                "\n" +
                "与传统类型不同，Sun微系统在推出Java时就将其作为开放的技术。全球的Java开发公司被要求所设计的Java软件必须兼容。“Java语言靠群体的力量而非公司的力量”是Sun微系统的口号之一，并获得了广大软件开发商的认同。这与微软公司所倡导的注重精英和封闭式的模式完全不同，此外，微软公司后来推出了与之竞争的.NET平台以及模仿Java的C#语言。后来Sun微系统被甲骨文公司并购[15]，Java也随之成为甲骨文公司的产品。\n" +
                "\n" +
                "目前，移动操作系统Android大部分的代码采用Java编程语言编程。";
        // 1. \\d代表任意地数字
        String regStr = "(\\d\\d)(\\d\\d)";
        // 2. 创建模式对象 [即正则表示对象]
        Pattern pattern = Pattern.compile(regStr);
        // 3.创建匹配器

        // 这个匹配器matcher, 按照 正则表达式规则 去匹配content内容
        Matcher matcher = pattern.matcher(content);

        /*
        matcher.find()
        源码分析
        1. 根据指定的规则, 定位满足的字符串(比如1990)
        2. 找到之后, 将子字符串开始的索引记录到mather对象的属性 int[] groups;
            group[0] = 84, 把该子字符串结束后的索引 + 1的值记录到 group[1] = 89
        3. 同时记录oldLast 的值为 子字符串结束后的索引 + 1的值 89 , 即下一次执行find时, 就从133开始


    public String group(int group) {
        if (first < 0)
            throw new IllegalStateException("No match found");
        if (group < 0 || group > groupCount())
            throw new IndexOutOfBoundsException("No group " + group);
        if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
            return null;
        return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
    }
         */
        while (matcher.find()) {
            System.out.println("找到 : " + matcher.group(0));
        }
    }
}
