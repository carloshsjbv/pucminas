import React from 'react';
import { Text } from '../..';
import { StyContainer, StyIcon } from './styles';

interface ISelectionItem {
  id: string;
  icon: React.FC<any>;
  itemKey: number;
  radiusBorder: string[];
  label: string;
  isActive: boolean;
  onChange: (selection: number) => void;
}

const SelectionItemCmp: React.FC<ISelectionItem> = ({
  id,
  label,
  radiusBorder = [],
  onChange,
  isActive,
  itemKey,
  icon,
}) => {
  const Icon: React.FC<any> = icon;
  return (
    <StyContainer
      id={id}
      active={isActive}
      radius={radiusBorder}
      onClick={() => onChange(itemKey)}
    >
      <StyIcon active={isActive}>
        <Icon />
      </StyIcon>
      <Text value={label} />
    </StyContainer>
  );
};

export default SelectionItemCmp;
