import React from 'react';
import { ClickItem, CircleSpinner } from '../../index';
import { StyContainer } from './styles';

interface IMenuItemCmp {
  id: string;
  label: string;
  onChange?: (...props: any) => void;
  onClick?: (...props: any) => void;
  loading?: boolean;
  disable?: boolean;
}

const MenuItemCmp: React.FC<IMenuItemCmp> = ({
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

export default MenuItemCmp;
