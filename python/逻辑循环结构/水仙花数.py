"""
水仙花数也被称为超完全数字不变数、自恋数、自幂数、阿姆斯特朗数，
它是一个3位数，该数字每个位上数字的立方之和正好等于它本身
"""

# i = str(input("请输入一个三位数:"))
#
# if len(i) != 3:
#     print("请输入三位数!!!")
#
# if int(i[0]) ** 3 + int(i[1]) ** 3 + int(i[2]) ** 3 == int(i):
#     print("是水仙花数")
# else:
#     print("不是水仙花数")

# 120
for i in range(100, 1000):
    low = i % 10
    mid = i // 10 % 10
    hig = i // 100

    if low ** 3 + mid ** 3 + hig ** 3 == i:
        print("%d是水仙花数" % i)
    # else:
        # print("%d不是水仙花数" % i)
