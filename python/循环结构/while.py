"""
猜数字游戏
"""
import random

answer = random.randint(1, 100)

count = 0

# while True:
#     count += 1
#     number = int(input("请输入你猜的数字: "))
#     # 如果猜的次数超过7器次 直接退出
#     if count > 7:
#         print("兄弟你的运气不是很好啊")
#         break
#     print("使用了%d次" % count)
#
#     if number > answer:
#         print("猜大了")
#     elif number < answer:
#         print("猜小了")
#     else:
#         print("猜中了!!!")
#         break


# 第二种写法
while True:
    count += 1
    number = int(input("请输入你猜的数字: "))
    if number > answer:
        print('big')
    elif number < answer:
        print('small')
    else:
        print('right')
        break

    print("你已经猜了 %d 次" % count)

if count > 7:
    print("很遗憾没有猜对")