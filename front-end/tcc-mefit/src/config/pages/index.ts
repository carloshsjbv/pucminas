import DashboardPage from '../../pages/dashboard';
import LoginPage from '../../pages/login';
import UserRegisterPage from '../../pages/user-register';
import WorkoutRegisterPage from '../../pages/workout-register';
import workoutPlanRegisterPage from '../../pages/workout-plan-register';
import WorkoutPlanRegisterStep2Page from '../../pages/workout-plan-register-step-2'
import workoutPlanRegisterStep3Page from '../../pages/workout-plan-register-step-3';
import WorkoutPlanRegisterStep4Page from '../../pages/workout-plan-register-step-4';
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
    alias: `workout-plan-register`,
    path: `/${appModule}/workout-plan-register`,
    template: Templates.PUBLIC,
    pageComponent: workoutPlanRegisterPage,
    mainMenu: MainMenu.NONE,
  },
  {
    alias: `workout-plan-register-step-2`,
    path: `/${appModule}/workout-plan-register-step-2`,
    template: Templates.PUBLIC,
    pageComponent: WorkoutPlanRegisterStep2Page,
    mainMenu: MainMenu.NONE,
  },
  {
    alias: `workout-plan-register-step-3`,
    path: `/${appModule}/workout-plan-register-step-3`,
    template: Templates.PUBLIC,
    pageComponent: workoutPlanRegisterStep3Page,
    mainMenu: MainMenu.NONE,
  },
  {
    alias: `workout-plan-register-step-4`,
    path: `/${appModule}/workout-plan-register-step-4`,
    template: Templates.PUBLIC,
    pageComponent: WorkoutPlanRegisterStep4Page,
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
