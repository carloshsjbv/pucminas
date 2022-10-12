import React, { ReactElement } from 'react';
import { ClickItem, CircleSpinner } from '../../index';
import { StyContainer, StyIconContainer } from './styles';

interface IButtonCmp {
  id: string;
  label: string;
  onChange?: (...props: any) => void;
  onClick?: (...props: any) => void;
  loading?: boolean;
  disable?: boolean;
  icon?: ReactElement;
}

const ButtonCircleCmp: React.FC<IButtonCmp> = ({
  id,
  label,
  onChange = () => null,
  onClick = () => null,
  loading = false,
  disable = false,
  icon,
}) => {
  return (
    <StyContainer>
      <StyIconContainer> {icon}</StyIconContainer>

      <ClickItem
        id={id}
        label=""
        onClick={onClick}
        onChange={onChange}
        disable={disable}
        loading={loading}
      />
    </StyContainer>
  );
};

export default ButtonCircleCmp;
