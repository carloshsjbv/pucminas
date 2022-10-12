import React from 'react';
import getAppPages from '../../config/pages';
import { IModuleContext } from '../../ts/interfaces/IModulesContext';

const appName = 'mefit';

export const ModulesContext: React.Context<any> = React.createContext({
  pages: getAppPages(),
  product: appName,
});

const ModulesProvider: React.FC = ({ children }) => {
  const ModuleValue: IModuleContext = {
    pages: getAppPages(),
    appName: appName,
  };
  return (
    <ModulesContext.Provider value={ModuleValue}>
      {children}
    </ModulesContext.Provider>
  );
};

export default ModulesProvider;
