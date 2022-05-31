import { createAvatar } from '@dicebear/avatars';
import * as style from '@dicebear/open-peeps';

export function generateAvatar(id: number | string) {
    return createAvatar(style, {
        seed: `${id}`,
        dataUri: true,
    });
}
