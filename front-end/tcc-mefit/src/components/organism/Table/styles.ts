import styled from 'styled-components';
import { primaryColor, secondaryColor } from '../../../styles/themes';

export const StyContainer = styled.div`
  font-size: 12px;
  width: 100%;
  height: 100%;
  padding: 10px;
  border-radius: 5px;
  display: flex;
  justify-content: center;
  align-items: center;
  table {
    border-collapse: collapse;
  }
`;

export const StyTableHeader = styled.th`
  font-size: 12px;
  padding: 15px;
  text-align: left;
  border-bottom: 1px solid #3a30426b;
  background-color: ${primaryColor};
  color: ${secondaryColor};
  min-width: 100px;
`;

export const StyTableRow = styled.tr`
  transition: all 0.2s ease-in;
  cursor: pointer;

  :hover {
    background-color: #db9d4721;
    transform: scale(1.02);
    box-shadow: 2px 2px 15px rgba(0, 0, 0, 0.2),
      -1px -1px 8px rgba(0, 0, 0, 0.2);
    color: ${secondaryColor};
    font-weight: 600;
  }
`;

export const StyTableData = styled.td`
  font-size: 12;
  padding: 15px;
  text-align: left;
  border-bottom: 1px solid #3a30426b;
`;
