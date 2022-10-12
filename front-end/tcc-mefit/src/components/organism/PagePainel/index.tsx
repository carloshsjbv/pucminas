import React from 'react';
import { StyContainer } from './styles';

interface IPagePanelCmp {}

const PagePanelCmp: React.FC<IPagePanelCmp> = ({ children }) => {
  return <div>{children}</div>;
};

export default PagePanelCmp;
