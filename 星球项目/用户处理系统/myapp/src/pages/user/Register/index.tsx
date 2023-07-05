import Footer from '@/components/Footer';
import {register} from '@/services/ant-design-pro/api';
import {LockOutlined, UserOutlined,} from '@ant-design/icons';
import {LoginForm, ProFormText,} from '@ant-design/pro-components';
import {message, Tabs} from 'antd';
import React, {useState} from 'react';
import {history, useModel} from 'umi';
import styles from './index.less';
import {PLANET_LINK, SYSTEM_LOGO} from "@/constants";

const Register: React.FC = () => {
  const [type, setType] = useState<string>('account');
  const {initialState, setInitialState} = useModel('@@initialState');
  const fetchUserInfo = async () => {
    const userInfo = await initialState?.fetchUserInfo?.();
    if (userInfo) {
      await setInitialState((s) => ({
        ...s,
        currentUser: userInfo,
      }));
    }
  };
  const handleSubmit = async (values: API.RegisterParams) => {
    try {
      const {userAccount, checkPassword, userPassword} = values;
      // 进行一些校验
      if (userPassword !== checkPassword) {
        message.error('两次输入的密码不一致');
        return;
      }

      // 注册
      const userId = await register({
        userAccount, userPassword, checkPassword
      });
      if (userId > 0) {
        const defaultLoginSuccessMessage = '注册成功！';
        message.success(defaultLoginSuccessMessage);
        await fetchUserInfo();
        /** 此方法会跳转到 redirect 参数所在的位置 */
        if (!history) return;
        const {query} = history.location;
        history.push('/user/login?redirect=', query,);
        return;
      } else {
        throw new Error(`register error id = ${userId}`)
      }
      // console.log(user);
      // // 如果失败去设置用户错误信息
      // setUserLoginState(user);
    } catch (error) {
      const defaultLoginFailureMessage = '注册失败，请重试！';
      message.error(defaultLoginFailureMessage);
    }
  };
  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <LoginForm
          submitter={{
            searchConfig: {
              submitText: '注册'
            }
          }}
          logo={<img alt="logo" src={SYSTEM_LOGO}/>}
          title="编程导航"
          subTitle={<a href={PLANET_LINK}>最好的编程学习圈子</a>}
          initialValues={{
            autoLogin: true,
          }}
          onFinish={async (values) => {
            await handleSubmit(values as API.RegisterParams);
          }}
        >
          <Tabs activeKey={type} onChange={setType}>
            <Tabs.TabPane key="account" tab={'账户密码注册'}/>
          </Tabs>

          {type === 'account' && (
            <>
              <ProFormText
                name="userAccount"
                fieldProps={{
                  size: 'large',
                  prefix: <UserOutlined className={styles.prefixIcon}/>,
                }}
                placeholder={'账号: '}
                rules={[
                  {
                    required: true,
                    message: '账号是必填项！',
                  },
                ]}
              />
              <ProFormText.Password
                name="userPassword"
                fieldProps={{
                  size: 'large',
                  prefix: <LockOutlined className={styles.prefixIcon}/>,
                }}
                placeholder={'密码: '}
                rules={[
                  {
                    required: true,
                    min: 8,
                    type: "string",
                    message: '密码长度不小于 8 位！',
                  },
                ]}
              />
              <ProFormText.Password
                name="checkPassword"
                fieldProps={{
                  size: 'large',
                  prefix: <LockOutlined className={styles.prefixIcon}/>,
                }}
                placeholder={'请再次输入密码: '}
                // 输入要求
                rules={[
                  {
                    required: true,
                    message: "确认密码是必填项！"
                  },
                  {
                    required: true,
                    min: 8,
                    type: "string",
                    message: '密码长度不小于 8 位！'
                  }
                ]}
              />
            </>
          )}
        </LoginForm>
      </div>
      <Footer/>
    </div>
  );
};
export default Register;
