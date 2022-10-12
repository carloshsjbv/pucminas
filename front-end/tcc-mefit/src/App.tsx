import React from 'react';
import ModulesProvider from './contexts/ModuleContext';
import RouteProvider from './routes/route-manager';
import GlobalStyle from './styles/global';

function App() {
  return (
    <>
      <ModulesProvider>
        <GlobalStyle />
        <RouteProvider />
      </ModulesProvider>
    </>
  );
}

export default App;
