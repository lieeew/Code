"""

分段函数求值

        3x - 5  (x > 1)
f(x) =  x + 2   (-1 <= x <= 1)
        5x + 3  (x < -1)


"""

f = int(input("x = "))

# if f > 1:
#     result = 3 * f - 5
# elif f < -1:
#     result = 5 * f + 3
# else:
#     result = f + 2


# 写法2 这种写法太不扁平话了
if f > 1:
    result = 3 * f - 5
else:
    if f < -1:
        result = 5 * f + 3
    else:
        result = f + 2


print("函数值为%d 的函数结果是 %d" % (f, result))

