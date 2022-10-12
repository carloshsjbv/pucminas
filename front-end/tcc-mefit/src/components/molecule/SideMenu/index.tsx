import React, { useContext, useEffect, useState } from 'react';
import { RouteContext } from '../../../routes/route-manager';
import { IMenuItem } from '../../../ts/interfaces/IMenuItem';
import { IPage, MainMenu } from '../../../ts/interfaces/IPage';
import { Accordion, SelectionItem } from '../../index';
import {
  IAccordionCmp,
  IAccordionItem,
  IAccordionSubItem,
} from '../../organism/Accordion';
import { StyContainer, StyItem, StyIcon, StyMenuContainer } from './styles';

interface SideMenuComponentProps {
  menus: IPage[];
  Logo: React.FC<any>;
}

const SideMenuComponent: React.FC<SideMenuComponentProps> = ({
  menus = [],
  Logo,
}) => {
  const [selectedMenu, setSelectedMenu] = useState<number>(0);
  const [closeMenu, setCloseMenu] = useState<boolean>(false);
  const [accordionMenus, setAccordionMenus] = useState<IAccordionItem[][]>([]);
  const { changeRoute }: any = useContext(RouteContext);

  /*menus.forEach((_menus:IPage[], _menuKey:string)=>{

  })*/

  useEffect(() => {
    // console.log('menus', menus);
    let mainMenu: MainMenu = MainMenu.NONE;
    let isFirst: boolean = true;
    //const accordionMenus: IAccordionItem[][] = [];
    const menusMap = new Map<MainMenu, IAccordionSubItem[]>();
    for (let i = 0; i < menus.length; i++) {
      const ignoreMenu: boolean = menus[i].mainMenu !== MainMenu.NONE;
      const subMenus: IAccordionSubItem[] | undefined = menusMap.get(
        menus[i].mainMenu,
      );

      if (menusMap.has(menus[i].mainMenu) && ignoreMenu && subMenus) {
        subMenus.push({
          subItemLabel: menus[i].alias,
          subItemOnClick: () => changeRoute(menus[i].alias),
        });
        menusMap.set(menus[i].mainMenu, subMenus);
      } else if (ignoreMenu) {
        menusMap.set(menus[i].mainMenu, []);
      }

      /*  if (isFirst && !ignoreMenu) {
        mainMenu = menus[i].mainMenu;
        menu.subItems = [
          {
            subItemLabel: menus[i].alias,
          },
        ];
        accordionMenus.push([menu]);
        isFirst = false;
      } else if (menu.itemLabel === !ignoreMenu) {
      }*/
    }
    menusMap.forEach((subMenus: IAccordionSubItem[], mainMenu: MainMenu) => {
      if (subMenus.length > 0) {
        const accordion: IAccordionItem = {
          itemLabel: mainMenu,
          subItems: subMenus,
        };
        accordionMenus.push([accordion]);
      }
    });
    setAccordionMenus([...accordionMenus]);
    console.log(accordionMenus);
  }, []);

  function onChange(itemKey: number) {
    setSelectedMenu(itemKey);
  }

  return (
    <StyContainer
      onMouseEnter={() => setCloseMenu(false)}
      onMouseLeave={() => setCloseMenu(true)}
    >
      <StyIcon>
        <Logo />
      </StyIcon>
      <ul>
        {accordionMenus.map((menu: IAccordionItem[], index: number) => {
          const isActive: boolean = index === selectedMenu;
          const id: string = `${menu}-${index}`;
          return <Accordion items={menu} id={id} reset={closeMenu} />;
        })}
      </ul>
    </StyContainer>
  );
};

export default SideMenuComponent;
/*
 accordionMenus.map((menu: IAccordionItem[], index: number) => {
   const isActive: boolean = index === selectedMenu;
   const id: string = `${menu}-${index}`;

   return (
     <Accordion items={menu} id={id} />
     /* <div>
              <StyMenuContainer>{menu[0].mainMenu}</StyMenuContainer>
              {menu.map((page: IPage) => {
                return (
                  <StyItem key={id} isActive={isActive}>
                    <SelectionItem
                      id={id}
                      icon={() => <div>icon</div>}
                      itemKey={index}
                      label={page.alias}
                      radiusBorder={['20px', '0px', '0px', '20px']}
                      isActive={isActive}
                      onChange={onChange}
                    />
                  </StyItem>
                );
              })}
            </div>
   );
 });
*/
