import styled from "styled-components";

const NavbarContainer = styled.nav`
  width: 100%;
  height: 80px;
  background-color: #1A6EED;
  display: flex;
  flex-direction: column;
  color: white;
  padding: 1em;
  font-weight: bold;
  font-size: 1.5em;
`;

const Navbar = () => { 
  return (
    <NavbarContainer>MeFit</NavbarContainer>
  )
}

export default Navbar