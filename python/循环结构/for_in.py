"""
用for循环实现1~100求和
"""
sum = 0
for x in range(101):
    sum += x
print(sum)


"""
这种用循环的方式不是很好, 可以使用步数直接跳过奇数
"""
num2 = 0
for x in range(101):
    if x % 2 == 0:
        num2 += x
print(num2)


num3 = 0
for x in range(2, 101, 2):
    num3 += x
print(num3)