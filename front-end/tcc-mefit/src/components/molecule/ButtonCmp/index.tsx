import React, { ReactElement } from 'react';
import { ClickItem, CircleSpinner } from '../../index';
import { StyContainer } from './styles';

interface IButtonCmp {
  id: string;
  label: string;
  onChange?: (...props: any) => void;
  onClick?: (...props: any) => void;
  loading?: boolean;
  disable?: boolean;
  icon?: ReactElement;
  width?: string;
}

const ButtonCmp: React.FC<IButtonCmp> = ({
  id,
  label,
  onChange = () => null,
  onClick = () => null,
  loading = false,
  disable = false,
  icon,
  width = '120px',
}) => {
  return (
    <StyContainer width={width}>
      <ClickItem
        id={id}
        label={label}
        onClick={onClick}
        onChange={onChange}
        disable={disable}
        loading={loading}
        icon={icon}
      />
    </StyContainer>
  );
};

export default ButtonCmp;
