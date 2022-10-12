import React from 'react';
import { ClickItem, CircleSpinner } from '../../index';
import { StyContainer } from './styles';

interface IButtonCmp {
  id: string;
  label: string;
  onChange?: (...props: any) => void;
  onClick?: (...props: any) => void;
  loading?: boolean;
  disable?: boolean;
}

const ButtonRoundedCmp: React.FC<IButtonCmp> = ({
  id,
  label,
  onChange = () => null,
  onClick = () => null,
  loading = false,
  disable = false,
}) => {
  return (
    <StyContainer>
      <ClickItem
        id={id}
        label={label}
        onClick={onClick}
        onChange={onChange}
        disable={disable}
        loading={loading}
      />
    </StyContainer>
  );
};

export default ButtonRoundedCmp;
