import React from 'react';
import { useModal } from '../context/modal.store';

type Props = {};

const Modal = (props: Props) => {
    const modal = useModal((state) => state.comonent);
    return modal ? (
        <div className="fixed z-50 grid h-screen w-screen place-items-center bg-modal backdrop-blur-sm">{modal}</div>
    ) : null;
};

export default Modal;
