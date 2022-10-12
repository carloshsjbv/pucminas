import React from 'react';
import {
  StyContainer,
  StyTableHeader,
  StyTableData,
  StyTableRow,
} from './styles';

interface ITableCmp {
  headers: string[];
  rows: ITableInfo[];
}

export interface ITableInfo {
  isRequired: string;
  description: string;
  attributeName: string;
  type: string;
}

const TableInfoCmp: React.FC<ITableCmp> = ({ headers, rows }) => {
  return (
    <StyContainer>
      <table>
        {headers.map((header: string) => {
          return <StyTableHeader>{header}</StyTableHeader>;
        })}
        {rows.map((row: ITableInfo) => {
          return (
            <StyTableRow>
              <StyTableData>{row.attributeName}</StyTableData>
              <StyTableData>{row.type}</StyTableData>
              <StyTableData>{row.isRequired}</StyTableData>
              <StyTableData>{row.description}</StyTableData>
            </StyTableRow>
          );
        })}
      </table>
    </StyContainer>
  );
};

export default TableInfoCmp;
