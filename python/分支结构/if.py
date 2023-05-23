username = input("请输入账号: ")

password = input("请输入密码: ")

if username == "admin" and password == "123456":
    print('登录成功')
else:
    print("登录失败")