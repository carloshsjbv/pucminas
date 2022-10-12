import DashboardPage from '../../pages/dashboard';
import LoginPage from '../../pages/login';
import UserRegisterPage from '../../pages/user-register';
import WorkoutRegisterPage from '../../pages/workout-register';
import { Templates } from '../../ts/enum/page-templates';
import { IPage, MainMenu } from '../../ts/interfaces/IPage';
const appModule: string = 'mefit';

const appPages: IPage[] = [
  {
    alias: `login`,
    path: `/${appModule}/login`,
    template: Templates.PUBLIC,
    pageComponent: LoginPage,
    mainMenu: MainMenu.NONE,
  },
  {
    alias: `dashboard`,
    path: `/${appModule}/dashboard`,
    template: Templates.PUBLIC,
    pageComponent: DashboardPage,
    mainMenu: MainMenu.NONE,
  },
  {
    alias: `workout-register`,
    path: `/${appModule}/workout-register`,
    template: Templates.PUBLIC,
    pageComponent: WorkoutRegisterPage,
    mainMenu: MainMenu.NONE,
  },
  {
    alias: `user-register`,
    path: `/${appModule}/user-register`,
    template: Templates.PUBLIC,
    pageComponent: UserRegisterPage,
    mainMenu: MainMenu.NONE,
  },
];

export default function getAppPages() {
  return appPages;
}
