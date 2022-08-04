import React from "react";
import MandatorySignal from "./MandatorySignal.styles"

const Input = ({ className, cType, cWidth, cPlaceholder, cMandatory }) => {
    if (cMandatory) {
        return (
            <div>
                <input className={className} type={cType} width={cWidth} placeholder={cPlaceholder} />
                <MandatorySignal />
            </div>)
    }
    return (
        <div>
            <input className={className} type={cType} width={cWidth} placeholder={cPlaceholder} />
        </div>
    );

}

export default Input;