import styled, { css } from 'styled-components';
const primaryColor: string = '#3A3042';
const secondaryColor: string = '#DB9D47';

interface IStyContainer {
  active: boolean;
  radius: string[];
}

export const StyContainer = styled.li<IStyContainer>`
  width: 100%;
  height: 50px;
  position: relative;
  list-style: none;
  display: flex;
  //justify-content: space-evenly;
  align-items: center;
  cursor: pointer;

  span {
    text-decoration: none;
    color: ${props => (props.active ? primaryColor : secondaryColor)};
    position: relative;
    display: block;
    padding-left: 10px;
    height: 60px;
    line-height: 60px;
    white-space: nowrap;
    overflow-x: hidden;
    margin-left: 5px;
  }

  ${props =>
    props.active &&
    css`
      background: ${secondaryColor};
    `}

  ${props =>
    props.radius &&
    css`
      border-radius: ${() =>
        `${props.radius[0]} ${props.radius[1]} ${props.radius[2]} ${props.radius[3]}`};
    `}
`;

interface IStyIcon {
  active: boolean;
}

export const StyIcon = styled.div<IStyIcon>`
  display: block;
  margin-left: 10px;
  svg {
    width: 30px;
    height: 30px;
    fill: ${props => (props.active ? primaryColor : secondaryColor)};
  }
`;
