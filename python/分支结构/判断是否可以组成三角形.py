"""
判断输入的边长能否构成三角形，如果能则计算出三角形的周长和面积

"""

a = float(input("第一条边: "))
b = float(input("第二条边: "))
c = float(input("第三条边: "))

if a + b > c and a + c > b and b + c > a:
    print('周长是: %f' % (a + b + c))
    print("可以构成三角形")
    p = (a + b + c) / 2
    area = (p * (p - a) * (p - b) * (p - c)) ** 0.5
    print('面积: %f' % (area))
else:
    print("不可以构成三角形")
