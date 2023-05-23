"""

如果输入的成绩在
90分以上（含90分）输出A；
80分-90分（不含90分）输出B；
70分-80分（不含80分）输出C；
60分-70分（不含70分）输出D；
60分以下输出E
"""

score = float(input("输入成绩: "))

if score >= 90:
    print("A")
elif 80 <= score < 90:
    print("B")
elif 70 <= score < 80:
    print("C")
elif 60 <= score < 70:
    print("D")
else:
    print("E")