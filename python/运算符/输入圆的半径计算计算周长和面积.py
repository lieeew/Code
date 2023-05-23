import math

f = float(input("请输入圆的半径"))

perimeter = math.pi * 2 * f

area = math.pi * f * f

# %.2f 表示占位符是小数点2位
print('半径为%f 计算后周长是 %.3f 面积为 %.2f' % (f, perimeter, area))

