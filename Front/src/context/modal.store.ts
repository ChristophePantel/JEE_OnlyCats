import React from 'react';
import create from 'zustand';

interface ModalState {
    comonent: React.ReactNode | null;
    setModal: (comonent: React.ReactNode) => void;
    clearModal: () => void;
}

export const useModal = create<ModalState>()((set, get) => ({
    comonent: null,
    setModal: (comonent: React.ReactNode) => {
        set({ comonent });
    },
    clearModal: () => {
        set({ comonent: null });
    },
}));
