import React from 'react';
import { Templates } from '../../enum/page-templates';

export enum MainMenu {
  ATOM = 'ATOM',
  PAGE = 'PAGE',
  FORM = 'FORM',
  NONE = 'NONE',
}

export interface IPage {
  alias: string;
  path: string;
  template: Templates;
  pageComponent: React.FC;
  mainMenu: MainMenu;
}
