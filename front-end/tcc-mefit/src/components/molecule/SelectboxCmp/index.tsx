import React, { ReactElement, useState } from 'react';
import { ClickItem, CircleSpinner } from '../../index';
import {
  StyContainer,
  StyOption,
  StySelectBox,
  StyOptionsContainer,
} from './styles';

interface ISelectboxCmp {
  id: string;
  label: string;
  onChange?: (...props: any) => void;
  onClick?: (...props: any) => void;
  loading?: boolean;
  disable?: boolean;
  icon?: ReactElement;
  options?: IOption[];
}

interface IOption {
  value: string;
  label: string;
}

const SelectboxCmp: React.FC<ISelectboxCmp> = ({
  id,
  label,
  onChange = () => null,
  onClick = () => null,
  loading = false,
  disable = false,
  icon,
  options = [],
}) => {
  const [expand, setExpand] = useState<boolean>(false);

  function handleClick() {
    setExpand(!expand);
  }

  return (
    <>
      <StyContainer isExpand={expand}>
        <input type="text" placeholder="Selecione" onClick={handleClick} />
        <StyOptionsContainer isExpand={expand}>
          {options.map(option => {
            return <StyOption>{option.label}</StyOption>;
          })}
        </StyOptionsContainer>
      </StyContainer>
    </>
  );
};

export default SelectboxCmp;
