import React, { ReactElement } from 'react';
import { Code, ComponentBlocks, Table } from '../..';
import { ITableInfo } from '../Table';
import {
  StyContainer,
  StyTitle,
  StyDescription,
  StySubtitle,
  StySubtitleContainer,
  StyCodeContainer,
} from './styles';

interface IComponentInfoCmp {
  components?: ReactElement[];
  description?: string;
  title?: string;
  subtitle?: string;
  codeExemple: string[];
  showAttributes?: boolean;
  componentAttributes?: ITableInfo[];
}

const ComponentInfoCmp: React.FC<IComponentInfoCmp> = ({
  components = [],
  title,
  subtitle,
  description,
  codeExemple,
  showAttributes = false,
  componentAttributes = [],
}) => {
  return (
    <StyContainer>
      <StyTitle>
        <h1>{title}</h1>
      </StyTitle>
      <StyDescription>
        <p>{description}</p>
      </StyDescription>
      <StySubtitleContainer>
        <StySubtitle>
          <h4>{subtitle}</h4>
        </StySubtitle>
        <ComponentBlocks components={components} />
      </StySubtitleContainer>
      <StyCodeContainer>
        <h4>{'Código:'}</h4>
        <Code lines={codeExemple} />
      </StyCodeContainer>
      {showAttributes && (
        <StyCodeContainer>
          <h4>{'Atributos:'}</h4>
          <Table
            headers={['Nome', 'Requerido', 'Tipo', 'Descrição']}
            rows={componentAttributes}
          />
        </StyCodeContainer>
      )}
    </StyContainer>
  );
};

export default ComponentInfoCmp;
