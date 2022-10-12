import React, { useEffect, useState } from 'react';
import { ClickItem, ComponentBlocks, MenuItem } from '../../index';
import {
  StyContainer,
  StySubItemContainer,
  StySubItem,
  StyItem,
} from './styles';

export interface IAccordionCmp {
  id: string;
  items: IAccordionItem[];
  reset: boolean;
}

export interface IAccordionItem {
  itemLabel: string;
  itemOnClick?: Function;
  subItems?: IAccordionSubItem[];
}

export interface IAccordionSubItem {
  subItemLabel: string;
  subItemOnClick: Function;
}

const AccordionCmp: React.FC<IAccordionCmp> = ({ id, items, reset }) => {
  const [openItemId, setOpenItemId] = useState<number>(-1);

  function handleClick(itemId: number) {
    if (itemId === openItemId) {
      setOpenItemId(-1);
    } else {
      setOpenItemId(itemId);
    }
  }

  function handleSubItemClick(itemId: number, onClick: Function) {
    onClick();
  }

  function handleChange() {}

  useEffect(() => {
    if (true) {
      setOpenItemId(-1);
    }
  }, [reset]);

  return (
    <StyContainer>
      {items.map((item: IAccordionItem, index: number) => {
        return (
          <>
            <StyItem isOpen={openItemId === index}>
              <ClickItem
                id={`${id}-menu-${index}`}
                label={item.itemLabel}
                onClick={() => handleClick(index)}
                onChange={handleChange}
                disable={false}
                loading={false}
              />
            </StyItem>

            <StySubItemContainer isOpen={openItemId === index}>
              {item.subItems &&
                item.subItems.map(
                  (subItem: IAccordionSubItem, subItemIndex: number) => {
                    return (
                      <StySubItem>
                        <ClickItem
                          id={`${id}-sub-${subItemIndex}`}
                          label={subItem.subItemLabel}
                          onClick={() =>
                            handleSubItemClick(
                              subItemIndex,
                              subItem.subItemOnClick,
                            )
                          }
                          onChange={handleChange}
                          disable={false}
                          loading={false}
                        />
                      </StySubItem>
                    );
                  },
                )}
            </StySubItemContainer>
          </>
        );
      })}
    </StyContainer>
  );
};

export default AccordionCmp;
