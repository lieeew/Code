import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import {PLANET_LINK} from "@/constants";
const Footer: React.FC = () => {
  const defaultMessage = 'leikooo出品';
  const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      copyright={`${currentYear} ${defaultMessage}`}
      links={[
        {
          key: 'codeNav',
          title: '编程导航',
          href: 'https://www.code-nav.cn/',
          blankTarget: true,
        },
        {
          key: 'github',
          title: <><GithubOutlined /> leikooo GitHub </>,
          href: 'https://github.com/lieeew',
          blankTarget: true,
        },
        {
          key: 'Ant Design',
          title: '知识星球',
          href: PLANET_LINK,
          blankTarget: true,
        },
      ]}
    />
  );
};
export default Footer;
