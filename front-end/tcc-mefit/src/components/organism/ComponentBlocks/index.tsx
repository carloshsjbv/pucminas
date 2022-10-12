import React, { ReactElement } from 'react';
import { StyContainer, StyComponentContainer } from './styles';

interface IComponentBlocks {
  components: ReactElement[];
}

const ComponentBlocksCmp: React.FC<IComponentBlocks> = ({
  components = [],
}) => {
  return (
    <StyContainer>
      {components.map((component: ReactElement) => {
        return <StyComponentContainer>{component}</StyComponentContainer>;
      })}
    </StyContainer>
  );
};

export default ComponentBlocksCmp;
