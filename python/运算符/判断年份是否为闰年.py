# 公元年份為4的倍數但非100的倍數
f = int(input("请输入年份: "))

b = (f % 4 == 0 and f % 100 != 0 ) or f % 400 == 0

print(b)
